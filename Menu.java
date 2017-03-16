import java.util.*;

class Card {
	String book_title;
	String book_author;
	String book_subject;

	public Card(String book_title,String book_author,String book_subject) {
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_subject = book_subject;
	}
}

class CardCatalog {
	Card[] title_array;
	Card[] author_array;
	Card[] subject_array;
	int no_of_books;
	Scanner s1;

	public CardCatalog() {
		title_array = new Card[10];
		author_array = new Card[10];
		subject_array = new Card[10];
		no_of_books = 0;
		s1 = new Scanner(System.in);
	}

	public void addACard(Card card) {
		Boolean flag1 = false;
		Boolean flag2 = false;
		Boolean flag3 = false;
		int imp = no_of_books;
		 if(no_of_books == 0) {
		 	title_array[0] = card;
		 	subject_array[0] = card;
		 	author_array[0] = card;
		 	no_of_books++;
		 } else {
		 	for(int i = 0; i < no_of_books;i++) {
		 		if(card.book_title.compareTo(title_array[i].book_title) < 0) {
		 			for(int j = no_of_books; j >i ;j--) {
		 				title_array[j] = title_array[j-1];
		 			}
		 			title_array[i] = card;
		 			flag1 = true;
		 			break;
		 		}
		 	}
		 	for(int k = 0; k < no_of_books;k++) {
		 		//System.out.println("val of k " + k);
		 		//System.out.println(subject_array[k].book_subject);
		 		//System.out.println(no_of_books);
		 		if(card.book_subject.compareTo(subject_array[k].book_subject) < 0) {
		 			for(int l = no_of_books; l >k ;l--) {
		 				subject_array[l] = subject_array[l-1];
		 				System.out.println(subject_array[l].book_subject);
		 			}
		 			subject_array[k] = card;
		 			flag2 = true;
		 			break;
		 		}
		 	}
		 	//System.out.println(flag2);
		 	
		 	for(int m = 0; m < no_of_books;m++) {
		 		if(card.book_author.compareTo(author_array[m].book_author) < 0) {
		 			for(int n = no_of_books; n >m ;n--) {
		 				author_array[n] = author_array[n-1];
		 			}
		 			author_array[m] = card;
		 			flag3 = true;
		 			break;
		 		}
		 	}


		 	if(!flag1 && !flag2 && !flag3) {
		 		//System.out.println("three");
		 		imp++;
		 		title_array[imp] = card;
		 		subject_array[imp] = card;
		 		author_array[imp] = card;
		 		imp--;
		 	}
		 	 else {
		 	 	if (!flag1) {
			 		title_array[imp++] = card;
			 		imp--;
			 	}
			 	if (!flag2) {
			 		//System.out.println("hi");
			 		subject_array[imp++] = card;
			 		imp--;
			 	}
			 	if (!flag3) {
			 		author_array[imp++] = card;
			 		imp--;
			 	}
		 	 } 
		 	//System.out.println(flag2);
		 	no_of_books++;
		 }
	}

	public String getATitle(String title) {
		String d = "Book not in Catalog";
		title = title.toLowerCase();
		for(int i = 0; i < no_of_books;i++) {
			if(title_array[i].book_title.toLowerCase().contains(title)) {
				return title_array[i].book_title;
			}
		}
		return d;
	}

	public void getAnAuthor(String author) {
		int count = 0;
		author = author.toLowerCase();
		for(int i = 0; i < no_of_books;i++) {
			if(author_array[i].book_author.toLowerCase().contains(author)) {
				System.out.println(author_array[i].book_title);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("Books written by " + author + " not in library Catalog");
		}
	}

	public void getSubject(String subject) {
		subject = subject.toLowerCase();
		int count = 0;
		for(int i = 0; i < no_of_books;i++) {
			if(subject_array[i].book_subject.toLowerCase().contains(subject)) {
				System.out.println(subject_array[i].book_title);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("No books related to " + subject);
		}
	}

	public void removeATitle(String title) {
		title = title.toLowerCase();
		for(int i = 0; i < no_of_books; i++) {
			if(title_array[i].book_title.toLowerCase().equals(title)) {
				for(int j = i; j < no_of_books - 1;j++) {
					title_array[j] = title_array[j+1];
				}
				break;
			}
		}

		for(int i = 0; i < no_of_books; i++) {
			if(author_array[i].book_title.toLowerCase().equals(title)) {
				for(int j = i; j < no_of_books - 1;j++) {
					author_array[j] = author_array[j+1];
				}
				break;
			}
		}

		for(int i = 0; i < no_of_books; i++) {
			if(subject_array[i].book_title.toLowerCase().equals(title)) {
				for(int j = i; j < no_of_books - 1;j++) {
					subject_array[j] = subject_array[j+1];
				}
				break;
			}
		}
		no_of_books--;
	}

	public void printTheCatalog() {
		System.out.println("Select the order by which books should be printed");
		System.out.println("1. Title of book");
		System.out.println("2. Author of book");
		System.out.println("3. Subject of book");
		int n = s1.nextInt();
		if(n == 1) {
			System.out.println("<----Sorted by title------------->");
			for(int i = 0; i < no_of_books;i++) {
				System.out.println("<------Book "+ i +"------->");
				System.out.println("Book Title -->" + title_array[i].book_title);
				System.out.println("Book Subject -->" + title_array[i].book_subject);
				System.out.println("Book Author -->" + title_array[i].book_author);
				System.out.println("<------End of Book " + i +"------->");
				System.out.println();
			}	
		} else if(n == 2) {
			System.out.println("<----Sorted by AuthorName------------->");
			for(int i = 0; i < no_of_books;i++) {
				System.out.println("<------Book "+ i +"------->");
				System.out.println("Book Author -->" + author_array[i].book_author);
				System.out.println("Book Subject --> " + author_array[i].book_subject);
				System.out.println("Book Title --> " + author_array[i].book_title);
				System.out.println("<------End of Book " + i +"------->");
				System.out.println();
			}
		} else if( n == 3) {
			System.out.println("<----Sorted by SubjectName------------->");
			for(int i = 0; i < no_of_books;i++) {
				System.out.println("<------Book "+ i +"------->");
				System.out.println("Book Subject -->" + subject_array[i].book_subject);
				System.out.println("Book Author --> " + subject_array[i].book_author);
				System.out.println("Book Title --> " + subject_array[i].book_title);
				System.out.println("<------End of Book " + i +"------->");
				System.out.println();
			}
		} 
	}
}

class Menu {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CardCatalog cardCatalogObj = new CardCatalog();
		int n;
		do {
			System.out.println("Select from the following");
			System.out.println("1. Add a card");
			System.out.println("2. Find the book by title");
			System.out.println("3. Find the books by author name");
			System.out.println("4. Find the books related to subject");
			System.out.println("5. Remove a title");
			System.out.println("6. Print the Catalog");
			System.out.println("7. exit");
			n = s.nextInt();
			if(n == 1) {
				System.out.println("Enter the title");
				String title = s.next();
				System.out.println("Enter author name");
				String author = s.next();
				System.out.println("Enter subject");
				String subject = s.next();
				Card cardObj = new Card(title,author,subject);
				cardCatalogObj.addACard(cardObj);
			} else if (n == 2) {
				System.out.println("Enter the title");
				String ans = s.next();
				System.out.println(cardCatalogObj.getATitle(ans));
			} else if (n == 3) {
				System.out.println("Enter the author name");
				cardCatalogObj.getAnAuthor(s.next());
			} else if (n == 4) {
				System.out.println("Enter the subject");
				cardCatalogObj.getSubject(s.next());
			} else if (n == 5) {
				System.out.println("Enter the title");
				cardCatalogObj.removeATitle(s.next());
			} else if (n == 6) {
				cardCatalogObj.printTheCatalog();
			}
		}while(n != 7);
 	}
}