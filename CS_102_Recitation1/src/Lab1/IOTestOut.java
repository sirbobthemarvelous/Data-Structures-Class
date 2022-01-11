package Lab1;
import java.io.IOException;
import java.util.Scanner;

public class IOTestOut {
	public static void main(String[] args) throws IOException {
		Scanner w = new Scanner(System.in);
		System.out.println("Enter integer value of width:");
		String width = w.nextLine();
		System.out.println("Your width value is:"+width);
		Scanner l = new Scanner(System.in);
		System.out.println("Enter integer value of length:");
		String length = l.nextLine();
		System.out.println("Your length value is:"+length);

		try {
			int len = Integer.parseInt(length);
			int wid = Integer.parseInt(width);
			Rectangle test = new Rectangle(wid,len);
			System.out.println("The Area of the Rectangle is: " +test.getArea());
		}
		catch (NumberFormatException e)
        {
            System.out.println("IOException occured");
            System.out.println("Please enter an integer");
        }
	}

}
