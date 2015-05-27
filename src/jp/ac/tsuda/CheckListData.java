package jp.ac.tsuda;

import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CheckListData {
	    @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	     
	    @Persistent
	    private String data;
	     
	    @Persistent
	    private int price;
	     
	 
	    public CheckListData(String data, int price) {
	        super();
	        this.data = data;
	        this.price = price;
	    }
	 
	    public Long getId() {
	        return id;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public String getData() {
	        return data;
	    }
	 
	    public void setData(String data) {
	    	this.data = data;
	    }
	    
	    public int getPrice() {
	        return price;
	    	}
	    
	    public void setPrice(int price) {
	        	this.price = price;
	    	}
	    
}

