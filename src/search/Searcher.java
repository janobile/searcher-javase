package search;

import java.util.ArrayList;

import search.providers.DummySearch;

public abstract class Searcher implements ISearch{

	private static String searchProvider =  "dummy";
	
	public Searcher() {
		
	}

	@Override
	public abstract ArrayList<SearchItem> search(String key);
	
	public static Searcher getSearcher() {
		
		if (searchProvider.equals("dummy")) {
			return new DummySearch();
		} else if (searchProvider.equals("youtube")) {
			//return new YoutubeSearch();
		}
		
		return null;
		
	}
	
}
