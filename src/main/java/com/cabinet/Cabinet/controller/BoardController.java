package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dao.BoardDao;
import com.cabinet.Cabinet.dao.ImgDao;
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
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    private BoardDao boardDao;
    
    //deal
    @GetMapping("/all")
    public String goodsAll(Model model, final HttpSession session, @RequestParam Map<String, Object> paramMap) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }
        int startPage = (paramMap.get("startPage")!=null?Integer.parseInt(paramMap.get("startPage").toString()):1);
        
        int visiblePages = (paramMap.get("visiblePages")!=null?Integer.parseInt(paramMap.get("visiblePages").toString()):10);
        
        //전체 건수 가져오기
        int totalCnt = boardDao.getContentCnt(paramMap);
        
        int startLimitPage = 0;
        //2.mysql limit 범위를 구하기 위해 계산
        if(startPage==1){
            startLimitPage = 0;
        }else{
            startLimitPage = (startPage-1)*visiblePages;
        }
        
        paramMap.put("start", startLimitPage);
        
        //view 에서 보여줄 정보 추출
        model.addAttribute("startPage", startPage+"");//현재 페이지
        return "goodsAll";
    }

    @GetMapping("/detail")
    public String detailView(@RequestParam Map<String, Object> paramMap, Model model) {
    	model.addAttribute("replyList", boardDao.getReplyList(paramMap));
    	model.addAttribute("detailView", boardDao.getContentView(paramMap));
    	
    	return "detailView";
    }
    
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
                             HttpServletRequest req) throws IOException {
        // Model에 붙인 값을 가져오려면 Get 부분에서 추가한 객체를 받아와야한다.

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);

            if(!file.getOriginalFilename().isEmpty()) {
                String path = "C:\\attached/" + file.getOriginalFilename();
                file.transferTo(new File(path));

                boardDTO.setWriter(session.getAttribute("memName").toString());
                productDTO.setPdImg(path);

                boardService.setBoardData(boardDTO, productDTO);

            }

        }
        return "all";
    }

    @Autowired
    private ImgDao imgDao;

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
