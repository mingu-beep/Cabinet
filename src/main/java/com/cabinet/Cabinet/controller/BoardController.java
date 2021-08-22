package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dao.BoardDAO;
import com.cabinet.Cabinet.dao.ImgDAO;
import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import com.cabinet.Cabinet.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/board")
public class BoardController {
//Spring 웹의 구동 방식
//            1. Controller에서 RequestMapping을 통해 알맞은 Controller가 실행된다.
//                - 이때 RequestMapping은 각각 GetMapping과 PostMapping으로 대체 가능
//                - 반환형이 String일때에는 보여주고자하는 페이지를 구현한 html파일 이름을 return 해야 화면에 출력된다.
//                - 종종 메서드가 Model값을 받아오는 경우가 있는데, 이는 웹페이지에 보여주거나 받아오고 싶은 객체를 addAttribute를 통해 붙여 전달할 때 사용된다.
//                - DTO는 데이터를 담는 통, Model과의 차이점은 모델은 칸막이가 없다면 DTO는 칸막이가 있어 우리가 이름을 미리 붙여놓을 수 있고,
//                model을 통해서만 html로 보낼 수 있다..
//                - DAO는 직접적으로 데이터베이스와 통신하는 객체
//            2. Model에 붙힌 DTO를 통해 모델에서 받은 값을 이용할 수 있다. 즉 model을 사용하는 경우에는 Controller파일에서 하는게 좋을거 같다
//            3. model을 직접 사용하지 않고 데이터만을 사용하는 경우 Service에서 일반 클래스 구현하듯 구현하면 된다.
//            4. 처리가 끝난 데이터를 Dao에 전달하면 자동으로 mapper가 그 값을 받아 미리 입력해둔 쿼리가 실행되어 데이터베이스와 연동된다.

//    ** DTO에 구현하는 것 : 우리가 받아오고자하는 데이터, 메서드는 getter setter만 구현하는게 일반적
//    ** DAO에 구현하는 것 : 데이터베이스에서 하고자하는 일들을 추상화 메서드로 구현한다.
//    ** mapper에 구현하는 것 : 실제적인 데이터베이스 쿼리, 이때 parameterType에는 메서드에서 받는 데이터 타입을 명시하고 resultType은 흔히 우리가 말하는 return Type과 같다
    @Autowired
    private BoardService boardService;
    private BoardDAO boardDao;
    
    //deal
    @GetMapping("/all")
    public String goodsAll(Model model, final HttpSession session, @RequestParam Map<String, Object> paramMap) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        model.addAttribute("boardList",boardService.getBoardData());
        model.addAttribute("productList",boardService.getProductData());

        return "deal"; // 반환 타입이 String일 경우 어떤 templates을 불러올 건지 명시해줘야한다.
                           // 따라서 return 값은 html 파일 이름!
    }

    @GetMapping("/detail")
    public String detailView(@RequestParam("bdNo") int bdNo, Model model, final HttpSession session) {
        System.out.println(bdNo);
        model.addAttribute("memID", session.getAttribute("memID").toString());
        model.addAttribute("board",boardService.getBoardWithBdNo(bdNo));
        model.addAttribute("product",boardService.getProductWithBdNo(bdNo));
    	return "detail";
    }
//    
//    @GetMapping("/mylist/detail")
//    public String mydetailView(@RequestParam Map<String, Object> paramMap, Model model) {
//    	//model.addAttribute("replyList", boardDao.getReplyList(paramMap));
//    	//model.addAttribute("detailView", boardDao.getContentView(paramMap));
//    	
//    	return "/detail";
//    }
    
    @GetMapping("/upload")
    public String getUpload(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        // View에서 정보를 받아오기 위해 Model에 boardDTO라는 이름으로 BoardDTO 객체를 등록한다.
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("boardDTO", new BoardDTO());
        return "upload";
    }

    @PostMapping("/upload")
    public String postUpload(Model model, BoardDTO boardDTO, ProductDTO productDTO,
                             @RequestParam("file") MultipartFile file,
                             final HttpSession session,
                             HttpServletRequest req) throws IOException, ParseException {
        // Model에 붙인 값을 가져오려면 Get 부분에서 추가한 객체를 받아와야한다.

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);

            if(!file.getOriginalFilename().isEmpty()) {
                String path = "C:\\attached/" + file.getOriginalFilename();
                file.transferTo(new File(path));
                boardDTO.setMemID(session.getAttribute("memID").toString());
                boardDTO.setMemName(session.getAttribute("memName").toString());
                productDTO.setMemID(session.getAttribute("memID").toString());
                productDTO.setPdImg(path);

                boardService.setBoardData(boardDTO, productDTO);

            }
            return "deal";

        }
        return "deal";
    }


    @Autowired
    private ImgDAO imgDao;

    @RequestMapping(value="/formFile")
    public String formFile() {
    	return "formFile";
    }
    @RequestMapping(value="/saveImage")
    public String saveImage(BoardDTO boardDTO) {
    	try {
    		Map<String, Object> hmap = new HashMap<String, Object>();
    		hmap.put("img", boardDTO.getBdImg().getBytes());
    		imgDao.saveImage(hmap);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:/formFile";
    }
    
    //이미지 보이는 부분
    @RequestMapping(value="/view")
    public String view() {
    	return "view";
    }
    @RequestMapping(value = "/getImg")
    public ResponseEntity<byte[]> getImg() {
    	Map<String, Object> map = imgDao.getImg();
    	byte[] imageContent = (byte[]) map.get("img");
    	final HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.IMAGE_PNG);
    	return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }


    @GetMapping("/hot")
    public String goodsHot(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "hot";
    }

    @GetMapping("/event")
    public String goodsEvent(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "event";
    }
}
