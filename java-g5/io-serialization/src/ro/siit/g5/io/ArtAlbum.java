package ro.siit.g5.io;

public class ArtAlbum extends Book{
	
	private static final long serialVersionUID = 1L;
	
	private PageQuality pageQuality;

	public ArtAlbum(String author, String title, PageQuality pageQuality) {
		super(author, title);
		this.pageQuality = pageQuality;
	}
	
	public PageQuality getPageQuality() {
		return pageQuality;
	}
	
	
	
	@Override
	public String toString() {
		return "ArtAlbum [pageQuality=" + pageQuality + ", author=" + getAuthor() + ", title=" + getTitle()
				+ "]";
	}



	public static enum PageQuality {
		THIN_NORMAL, THIN_GLOSSY, THICK_NORMAL, THICK_GLOSSY
	}

}
