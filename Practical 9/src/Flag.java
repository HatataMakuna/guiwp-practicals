import javax.swing.*;

public class Flag {
	private String name;
	private ImageIcon imageIcon;
	private String description;
  
  public Flag() {
  }
  
  public Flag(String name, ImageIcon imageIcon, String description) {
  	this.name = name;
  	this.imageIcon = imageIcon;
  	this.description = description;
  }
  
  public String getName() {
  	return name;
  }
  
  public ImageIcon getImageIcon() {
  	return imageIcon;
  }
  
  public String getDescription() {
  	return description;
  }  
    
}