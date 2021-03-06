package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.ReplyDAO;
import com.cabinet.Cabinet.dto.ReplyDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private SqlSessionTemplate replySqlSession;
    private ReplyDAO replyDao;

    public List<ReplyDTO> replyListService(int bdNo) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyList(bdNo);
    }

    public List<ReplyDTO> replyCsListService(int csNo) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyCsList(csNo);
    }

    public int replyInsertService(ReplyDTO replyDTO) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyInsert(replyDTO);
    }
    public int csReplyInsertService(ReplyDTO replyDTO) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyCsInsert(replyDTO);
    }

    public int replyUpdateService(ReplyDTO replyDTO) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyUpdate(replyDTO);
    }
    public int replyCsUpdateService(ReplyDTO replyDTO) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyCsUpdate(replyDTO);
    }

    public int replyDeleteService(int replyNo) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyDelete(replyNo);
    }
    public int replyCsDeleteService(int replyNo) {
        replyDao = replySqlSession.getMapper(ReplyDAO.class);
        return replyDao.replyCsDelete(replyNo);
    }
}
