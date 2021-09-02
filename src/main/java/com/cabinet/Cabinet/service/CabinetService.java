package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.CabinetDAO;
import com.cabinet.Cabinet.dto.CabinetDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinetService {

    @Autowired
    private SqlSessionTemplate cabinetSqlSession;
    private CabinetDAO cabinetDAO;

    public List<CabinetDTO> findLocation() {
        cabinetDAO = cabinetSqlSession.getMapper(CabinetDAO.class);
        return cabinetDAO.findLocation();
    }

    public void setCabinet(int bdNo, int cnNo, String cnPW, String memID) {
        CabinetDTO cabinet = new CabinetDTO();
        cabinet.setPdNo(bdNo);
        cabinet.setCnNo(cnNo);
        cabinet.setCnPW(cnPW);
        cabinet.setCnReser(memID);

        cabinetDAO = cabinetSqlSession.getMapper(CabinetDAO.class);
        cabinetDAO.updateCabinet(cabinet);
    }

    public String getPassword(int cnNo) {
        cabinetDAO = cabinetSqlSession.getMapper(CabinetDAO.class);
        return cabinetDAO.getPassword(cnNo);
    }

    public void reSetCabinet(int cnNo) {
        cabinetDAO = cabinetSqlSession.getMapper(CabinetDAO.class);
        cabinetDAO.reSetCabinet(cnNo);
    }

    public boolean searchCabinet(int pdNo){
        cabinetDAO = cabinetSqlSession.getMapper(CabinetDAO.class);
        return cabinetDAO.findByPdNo(pdNo);
    }
}