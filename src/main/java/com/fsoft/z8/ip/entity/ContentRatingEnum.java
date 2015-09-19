package com.fsoft.z8.ip.entity;

public enum ContentRatingEnum {
    
    G("G", "General Audiences"),
    PG("PG", "Parental Guidance Suggested"),
    PG_13("PG-13", "Parents Strongly Cautioned"),
    R("R", "Restricted"),
    NC_17("NC-17", "Adults Only"),
    UNKNOWN("Unknown", "Unknown");
    
    private String code;
    private String name;

    private ContentRatingEnum(String code, String name) {
	this.code = code;
	this.name = name;
    }
    
    /**
     * @return the code
     */
    public String getCode() {
	return code;
    }

    /**
     * @return the value
     */
    public String getName() {
        return name;
    }
    
    public static ContentRatingEnum parse(String value) {
	if (G.getName().equals(value)) {
	    return G;
	} else if (NC_17.getName().equals(value)) {
	    return NC_17;
	} else if (PG.getName().equals(value)) {
	    return PG;
	} else if (PG_13.getName().equals(value)) {
	    return PG_13;
	} else if (R.getName().equals(value)) {
	    return R;
	}
	return UNKNOWN;
    }
}
