package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.ReplyDTO;

import java.util.List;

public interface ReplyDAO {

    // 댓글 개수
    public int replyCount();

    // 댓글 목록
    public List<ReplyDTO> replyList(int bdNo);
    public List<ReplyDTO> replyCsList(int csNo);

    // 댓글 작성
    public int replyInsert(ReplyDTO replyDTO);
    public int replyCsInsert(ReplyDTO replyDTO);

    // 댓글 수정
    public int replyUpdate(ReplyDTO replyDTO);
    public int replyCsUpdate(ReplyDTO replyDTO);

    // 댓글 삭제
    public int replyDelete(int replyNo);
    public int replyCsDelete(int replyNo);
}
