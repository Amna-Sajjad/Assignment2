import javax.swing.JOptionPane;

public class BookShop {
	public static void main(String args[]) {
		
	//Start of program	
		int choice=0,flag=0,add=0;
		int index=0,arraySize=0;
		String sBook=new String();
		String arrSize=JOptionPane.showInputDialog("Enter Array Size for Books: ");
		arraySize=Integer.parseInt(arrSize);
		Book books[]=new Book[arraySize];//book array
		do{
			String ch=JOptionPane.showInputDialog(null, "              *** MENU ***\n"
				+ "1. Add Book Record\n"
				+ "2. Add Anuthor to Book\n"
				+ "3. Display Book Record\n"
				+ "4. Change Book Price\n"
				+ "5. Change Book Quantity\n"
				+ "6. Update Author Email\n"
				+ "7. Display Authors of a Book\n"
				+ "8. Exit\n"
				+ "Enter Choice: ");
			choice=Integer.parseInt(ch);
			switch(choice) {
			case 1://Add new book record in array
				int aindex=0,want=0;
				if(index<arraySize) {
					String sbname=JOptionPane.showInputDialog("Enter Book Name: ");
					String sprice=JOptionPane.showInputDialog("Enter Book Price: ");
					double iprice=Double.parseDouble(sprice);
					Author author[]= new Author[5];//add array of authors
					do {
						if(aindex<5) {
							String sname=JOptionPane.showInputDialog("Enter Author Name: ");
							String semail=JOptionPane.showInputDialog("Enter Author Email: ");
							String sgender=JOptionPane.showInputDialog("Enter Author gender (m / f) :");
							char cgender=sgender.charAt(0);
							author[aindex]=new Author(sname,semail,cgender);
							aindex++;//count the authors
							want=JOptionPane.showConfirmDialog(null, "Do you want to add more Authors?",
									"Confrm Author",JOptionPane.YES_NO_OPTION);
						}
						else {
							JOptionPane.showMessageDialog(null, "Space is full cannot add more","Error",JOptionPane.WARNING_MESSAGE);
							want=JOptionPane.NO_OPTION;
						}
					}while(want==JOptionPane.YES_OPTION);
					
					int cnfrm=JOptionPane.showConfirmDialog(null, "Do you want to add Quantity of book also?",
							"Confrm Quantity",JOptionPane.YES_NO_OPTION);
					if(cnfrm==JOptionPane.YES_OPTION) {
						String squantity=JOptionPane.showInputDialog("Enter Book Quantity: ");
						int iquantity=Integer.parseInt(squantity);
						books[index]=new Book(sbname,author,iprice,iquantity);
					}
					else
						books[index]=new Book(sbname,author,iprice);
					index++;
				}
				else
					JOptionPane.showMessageDialog(null, "Array is full no more space Available",
							"Error",JOptionPane.WARNING_MESSAGE);
				break;
			case 2://Add new Author to a certain book
				add=0;
				flag=0;
				sBook=JOptionPane.showInputDialog("Enter Book name: ");
				for(int i=0;i<index && flag==0;i++) {
					if(sBook.compareTo(books[i].getName())==0) {
						Author ath[]=books[i].getAuthors();
						for(int j=0;j<ath.length;j++) {
							if(ath[j]!=null)
								add++;
						}
						if(add<5) {
							String sname=JOptionPane.showInputDialog("Enter Author Name: ");
							String semail=JOptionPane.showInputDialog("Enter Author Email: ");
							String sgender=JOptionPane.showInputDialog("Enter Author gender (m / f) :");
							char cgender=sgender.charAt(0);
							books[i].addAuthor(new Author(sname,semail,cgender));
						}
						else
							JOptionPane.showMessageDialog(null, "\nAuthor space is full we can not add more author to this book",
									"Error",JOptionPane.WARNING_MESSAGE);
						flag=1;
					}
				}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Can not find the Book OR",
							"Error",JOptionPane.WARNING_MESSAGE);
				break;
			case 3://display all book records
				for(int i=0;i<index;i++) {
					JOptionPane.showMessageDialog(null, books[i],"Display Book record",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case 4://change the price of a certain book
				flag=0;
				sBook=JOptionPane.showInputDialog("Enter Book name: ");
				for(int i=0;i<index && flag==0;i++) {
					if(sBook.compareTo(books[i].getName())==0) {
						String sPrice=JOptionPane.showInputDialog("Enter new Price: ");
						double dPrice=Double.parseDouble(sPrice);
						books[i].setPrice(dPrice);
						flag=1;
					}
				}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Can not find the Book",
							"Error",JOptionPane.WARNING_MESSAGE);
				break;
			case 5://change the quantity of a certain book
				flag=0;
				sBook=JOptionPane.showInputDialog("Enter Book name: ");
				for(int i=0;i<index && flag==0;i++) {
					if(sBook.compareTo(books[i].getName())==0) {
						String sQuan=JOptionPane.showInputDialog("Enter new Quantity: ");
						int iQuan=Integer.parseInt(sQuan);
						books[i].setPrice(iQuan);
						flag=1;
					}
				}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Can not find the Book",
							"Error",JOptionPane.WARNING_MESSAGE);
				break;
			case 6://change email of a certain author
				flag=0;
				add=0;
				String sAuthor=JOptionPane.showInputDialog("Enter Author name: ");
				for(int i=0;i<index && flag==0;i++) {
					Author ath[]=books[i].getAuthors();
					for(int j=0;j<ath.length;j++) {
						if(ath[j]!=null)
							add++;
					}
					for(int j=0;j<add;j++) {
						if(sAuthor.compareTo(ath[j].getName())==0) {
							String sEmail=JOptionPane.showInputDialog("Enter new Email: ");
							ath[j].setEmail(sEmail);
							flag=1;
						}
					}
				}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Can not find the Author",
							"Error",JOptionPane.WARNING_MESSAGE);
				break;
			case 7:
				flag=0;
				sBook=JOptionPane.showInputDialog("Enter Book name: ");
				for(int i=0;i<index && flag==0;i++) {
					if(sBook.compareTo(books[i].getName())==0) {
						books[i].printAuthors();
						flag=1;
					}
				}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Can not find the Book",
							"Error",JOptionPane.WARNING_MESSAGE);
				break;
			case 8://exit the program
				int result = JOptionPane.showConfirmDialog(null,
				        "Are you sure you want to quit?",
				        "Confirm Quit", JOptionPane.YES_NO_CANCEL_OPTION);
				if (result == JOptionPane.YES_OPTION) System.exit(0);
				break;
			}
		}while(choice<=7);
	}
}
