import javax.swing.JOptionPane;

public class TestAuthor {
	public static void main(String args[]) {
		String sname=JOptionPane.showInputDialog("Enter Author Name: ");
		String semail=JOptionPane.showInputDialog("Enter Author Email: ");
		String sgender=JOptionPane.showInputDialog("Enter Author gender (m / f) :");
		char cgender=sgender.charAt(0);
		Author author=new Author(sname,semail,cgender);
		JOptionPane.showMessageDialog(null,author);
		String newemail=JOptionPane.showInputDialog("Enter New Author Email: ");
		author.setEmail(newemail);
		JOptionPane.showMessageDialog(null,author);
	}
}
