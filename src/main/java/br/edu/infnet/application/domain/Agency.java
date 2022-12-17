package br.edu.infnet.application.domain;

public class Agency {
    private String city;
    private String state;
    private int code;

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    public String getState() {
		return state;
	}
    
	public void setState(String state) {
		this.state = state;
	}

    public int getCode() {
		return code;
	}
    
	public void setCode(int code) {
		this.code = code;
	}

    public String getLocale() {
        String locale = this.city + "-" + this.state.toUpperCase();

        System.out.println(locale
        );
		return locale;
	}
}