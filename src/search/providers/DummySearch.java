package search.providers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import search.SearchItem;
import search.Searcher;

public class DummySearch extends Searcher {
	
	public DummySearch() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<SearchItem> search(String key) {
		
		ArrayList<SearchItem> listItems = new ArrayList<SearchItem>();
		
		for (int i = 0; i < 5; i++) {
			
			SearchItem item = new SearchItem();
			item.setTitle("Title #"+i);
			try {
				item.setImage(new URL("https://www.dokensip.com/wp-content/uploads/2017/04/Youtube.png"));
				item.setUrl(new URL("http://google.com/"+i));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			listItems.add(item);
		}
		return listItems;
	}

}
