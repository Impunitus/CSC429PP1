// Package Specification
package model;

// System imports
import java.util.Properties;
import java.util.Vector;
import javafx.scene.Scene;

// Project imports
import exception.InvalidPrimaryKeyException;
import event.Event;
import database.*;
import impresario.IView;
import userinterface.View;
import userinterface.ViewFactory;

/**
 * @author Caleb Butcher, Michael Carter
 * @since 2016-02-02
 */
//=========================================================
public class BookCollection extends EntityBase implements IView
{
	private static final String myTableName = "Book";

	private Vector<Book> books;

	/**
	 * BookCollection class constructor
	 */
	public BookCollection()
	{
		super(myTableName);
		books = new Vector<Book>();
	}

	/** */
	//-----------------------------------------------------------
	public void findBooksOlderThanDate(String year)
	{
		String query = "SELECT * FROM " + myTableName + " WHERE (pubYear < " + year + "";
		Vector allDataRetrieved = getSelectQueryResult(query);

		if (allDataRetrieved != null)
		{
			books = new Vector<Book>();

			for(int cnt = 0; cnt < allDataRetrieved.size(); cnt++)
			{
				Properties nextBookData = (Properties)allDataRetrieved.elementAt(cnt);

				Book book = new Book(nextBookData);

				if(book != null)
				{
					addBook(book);
				}
			}
		}
		else
		{
			throw new InvalidPrimaryKeyException("No books younger than: " + year + "found" + year.getState("Book"));
		}
	}

	/** */
	//-----------------------------------------------------------
	public void findBooksWithTitleLike(String title)
	{

	}

	/** */
	//-----------------------------------------------------------
	public void findBooksWithAuthorLike(String author)
	{

	}
	//-----------------------------------------------------------
	private int findIndexToAdd(Book a)
	{
		//users.add(u);
		int low=0;
		int high = books.size()-1;
		int middle;

		while (low <=high)
		{
			middle = (low+high)/2;

			Book midSession = books.elementAt(middle);

			int result = Book.compare(a,midSession);

			if (result ==0)
			{
				return middle;
			}
			else if (result<0)
			{
				high=middle-1;
			}
			else
			{
				low=middle+1;
			}
		}
		return low;
	}
	//-----------------------------------------------------------
	public Object getState(String key)
	{
		if (key.equals("Books"))
			return books;
		else
		if (key.equals("BookList"))
			return this;
		return null;
	}
	//-----------------------------------------------------------
	public void updateState(String key, Object value)
	{
		stateChangeRequest(key, value);
	}
	//-----------------------------------------------------------
	public void stateChangeRequest(String key, Object value)
	{
		myRegistry.updateSubscribers(key, this);
	}
	//-----------------------------------------------------------
	private void addBook(Book a)
	{
		//books.add(a);
		int index = findIndexToAdd(a);
		books.insertElementAt(a,index); // To build up a collection sorted on some key
	}
	//-----------------------------------------------------------
	protected void initializeSchema(String tableName)
	{
		if (mySchema == null)
		{
			mySchema = getSchemaInfo(tableName);
		}
	}
}
