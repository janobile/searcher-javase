package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import search.SearchItem;
import search.Searcher;

public class SearchApp extends JFrame {

	JPanel mainPanel;
	JPanel searchPanel;
	JPanel resultPanel;
	JLabel lbTitle;
	JTextField txtSearch;
	JButton btSearch;
	Searcher searcher;
	
	public SearchApp() {

		mainPanel = (JPanel)this.getContentPane();
		searchPanel =  new JPanel();
		resultPanel = new JPanel();
		
		lbTitle = new JLabel("My Collections");
		txtSearch = new JTextField(20);
		btSearch = new JButton("Search");
		
		btSearch.addActionListener(new ActionListener() {
			
			// Aqui implemento la interface ActionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				search(txtSearch.getText());
			}
		});
		
		searchPanel.add(lbTitle);
		searchPanel.add(txtSearch);
		searchPanel.add(btSearch);
		
		mainPanel.add(searchPanel);
		mainPanel.add(resultPanel);
		
		searchPanel.setLayout(new FlowLayout());
		mainPanel.setLayout(new FlowLayout());
		resultPanel.setLayout(new FlowLayout());
		
		searcher = Searcher.getSearcher();
		
	}
	
	public void search(String key) {
		
		
		ArrayList<SearchItem> lisItems = searcher.search(key);
		
		for (SearchItem searchItem : lisItems) {
			JPanel panel = new JPanel();
			panel.add(new JLabel(searchItem.getTitle()));
			resultPanel.add(panel);
		}
		
		this.pack();
        //JLabel label = new JLabel(new ImageIcon(image));

	}

}
