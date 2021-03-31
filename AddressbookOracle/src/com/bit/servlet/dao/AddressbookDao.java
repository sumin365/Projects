package com.bit.servlet.dao;
import java.util.List;

import com.bit.servlet.model.AddressbookVo;
public interface AddressbookDao {


public List<AddressbookVo> getList();	//	SELECT
public int insert(AddressbookVo vo);	//	INSERT
public int delete(Long no);		//	DELETE by PK
public List<AddressbookVo> search(String a);
}