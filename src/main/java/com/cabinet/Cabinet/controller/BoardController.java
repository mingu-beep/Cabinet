package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import com.cabinet.Cabinet.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
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


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

//	@Resource(name="com.cabinet.Cabinet.dao.BoardMapper")
//	BoardMapper bm;
//
//	@RequestMapping("/board")
//	private String dbTest() throws Exception {
//		System.out.println(bm.boardCount());
//
//		return "test";
//	}

    @GetMapping("/all")
    public String goodsAll(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "deal";
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
        }

        String path = "C:\\attached/";

        if(!file.getOriginalFilename().isEmpty()) {
            file.transferTo(new File(path + file.getOriginalFilename()));
        }

        return "all";
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
