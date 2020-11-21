import javax.swing.JOptionPane;

public class Book {
	private String name;
	private Author []authors=new Author[5];
	private int numAuthors=0; //public data member
	private double price;
	private int qtyInStock;
 	public Book (String name, Author authors[], double price) {
 		this.name=name;
 		this.authors=authors;
 		this.price=price;
 		this.qtyInStock=0;
 		for(int i=0;i<authors.length;i++) {
 			if(authors[i]!=null)
 				this.numAuthors++;
 		}
 	}
 	public Book(String name, Author authors[], double price,int qtyInStock) {
 		this.name=name;
 		this.authors=authors;
 		this.price=price;
 		this.qtyInStock=qtyInStock;
 		for(int i=0;i<authors.length;i++) {
 			if(authors[i]!=null)
 				this.numAuthors++;
 		}
 	}
 	public String getName() {
 		return name;
 	}
 	public Author[] getAuthors() {
 			return authors;
 	}
 	public double getPrice() {
 		return price;
 	}
 	public void setPrice(double price) {
 		this.price=price;
 	}
 	public int getQtyInStock() {
 		return qtyInStock;
 	}
 	public void setQtyInStock(int qtyInStock) {
 		this.qtyInStock=qtyInStock;
 	}
 	public String toString() {
 		String str="";
 		for(int i=0;i<numAuthors;i++) {
 			str=str+"\'" + name + "\' by " + authors[i]+"\n";
 		}
 		return str;
 	}
 	public void printAuthors() {
 		for(int i=0;i<numAuthors;i++) {
 			JOptionPane.showMessageDialog(null, authors[i]);
 		}
 	}
 	public void addAuthor(Author ath) {
 			this.authors[numAuthors]=ath;
 			numAuthors++;
 	}
}
