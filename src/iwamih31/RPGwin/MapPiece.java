package iwamih31.RPGwin;

public class MapPiece {
	private int role;
	private String image;

	public MapPiece(String image, int role) {
		this.role = role;
		this.image = image;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
