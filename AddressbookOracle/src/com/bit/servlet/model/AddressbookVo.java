package com.bit.servlet.model;



public class AddressbookVo  {
    


	private Long no;
	private String name;
	private String cell_phone;
	private String home_phone;
	
	public AddressbookVo() {
	}

	public AddressbookVo(Long no, String name,  String cell_phone, String home_phone) {
		this.no = no;
		this.name = name;
		this.cell_phone = cell_phone;
		this.home_phone = home_phone;
		
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcell_phone() {
		return cell_phone;
	}

	public void setcell_phone(String cell_phone) {
		this.cell_phone =cell_phone;
	}

	public String gethome_phone() {
		return home_phone;
	}

	public void sethome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", cell_phone=" + cell_phone + ", home_phone=" + home_phone +" ]";
	}




}
