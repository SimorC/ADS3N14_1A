package controller;

import view.*;
import structure.*;
import utils.*;
import model.*;

/**
 * Controller class of the app
 * @author Simor
 *
 */
public class AppController {
	// Variables
	private AppView view;
	private Tree<Contact, String> list;
	private Node<Contact, String> currentNode;
	private ShowType showType;
	
	/**
	 * Constructor - Initialize variables
	 */
	public AppController()
	{
		list = ContactFile.loadContacts();
		view = new AppView();
		currentNode = list.getFirst();
	}
	
	/**
	 * Initial "screen"
	 */
	public void showContact()
	{
		int op = view.showContact(currentNode.getValue());
		switch (op)
		{
			case 1:
				nextContact();
				break;
			case 2:
				previousContact();
				break;
			case 3:
				addContact();
				break;
			case 4:
				deleteContact();
				break;
			case 5:
				searchContact();
				break;
			case 6:
				showTree();
				break;
			case 0:
				saveTree();
				System.exit(0);
				break;
			default:
				view.showMessage("Digite uma op��o v�lida!");
				break;
		}
		
		showContact();
	}
	
	/**
	 * Shows the previous Contact
	 */
	private void previousContact()
	{
		
	}
	
	/**
	 * Shows the next Contact
	 */
	private void nextContact()
	{
		
	}
	
	/**
	 * Search and show the found contact (If found)
	 */
	private void searchContact()
	{
		String key = view.searchContact();
		
		if (key != "")
		{
			Node<Contact, String> node = this.list.searchNode(key);
			
			// If found the key
			if (node != null)
			{
				this.currentNode = node;
			}
			else
			{
				view.showMessage("Nada encontrado!");
			}
		}
		
		showContact();
	}
	
	/**
	 * Add a Contact to the Tree
	 */
	private void addContact()
	{
		Contact contact = view.addContact();
		
		// Verifies if it has been given a valid info and add to the Tree
		if (contact != null)
		{
			Node<Contact, String> node = new Node<Contact, String>();
			node.setKey(contact.getName());
			node.setValue(contact);
			
			this.list.addNode(node, true);
		}
		else
		{
			view.showMessage("Insira dados v�lidos!");
		}
		
		showContact();
	}
	
	/**
	 * Delete a Contact from the Tree
	 */
	private void deleteContact()
	{
		this.list.deleteNode(currentNode);
		view.showMessage("Deletado com sucesso!");
		currentNode = list.getFirst();
		showContact();
	}
	
	/**
	 * Shows the Tree within the chosen method
	 */
	private void showTree()
	{
		ShowType showType = view.showTree();
		
		switch(showType)
		{
			case PreOrder:
				showPreOrder();
				break;
			case PostOrder:
				showPostOrder();
				break;
			case InOrder:
				showInOrder();
				break;
			case BreadthFirst:
				showBreadth();
				break;
			case DepthFirst:
				showDepth();
				break;
			default:
				view.showMessage("Selecione uma op��o v�lida!");
				break;
		}
		
		showContact();
	}
	
	/**
	 * Shows the Tree with the Pre-Order method
	 */
	private void showPreOrder()
	{
		showPreOrder(this.list.getRoot());
	}
	
	/**
	 * Shows the Tree with the Pre-Order method (Recursive)
	 * @param node Current Node
	 */
	private void showPreOrder(Node<Contact, String> node)
	{
		view.showKey(node);
		if (node.getLeftNode() != null)
		{
			showPreOrder(node.getLeftNode());
		}
		
		if (node.getRightNode() != null)
		{
			showPreOrder(node.getRightNode());
		}
	}
	
	/**
	 * Shows the Tree with the Post-Order method
	 */
	private void showPostOrder()
	{
		showPostOrder(this.list.getRoot());
	}
	
	/**
	 * Shows the Tree with the Post-Order method
	 * @param node Current Node
	 */
	private void showPostOrder(Node<Contact, String> node)
	{
		if (node.getLeftNode() != null)
		{
			showPostOrder(node.getLeftNode());
		}
		
		if (node.getRightNode() != null)
		{
			showPostOrder(node.getRightNode());
		}
		
		view.showKey(node);
	}
	
	/**
	 * Shows the Tree with the In-Order method
	 */
	private void showInOrder()
	{
		showInOrder(this.list.getRoot());
	}
	
	/**
	 * Shows the Tree with the In-Order method
	 * @param node Current Node
	 */
	private void showInOrder(Node<Contact, String> node)
	{
		if (node.getLeftNode() != null)
		{
			showInOrder(node.getLeftNode());
		}
		
		view.showKey(node);
		
		if (node.getRightNode() != null)
		{
			showInOrder(node.getRightNode());
		}
	}
	
	/**
	 * Shows the Tree with the Breadth First Search method
	 */
	private void showBreadth()
	{
		
	}
	
	/**
	 * Shows the Tree with the Depth First Method method
	 */
	private void showDepth()
	{
		
	}
	
	/**
	 * Save the Tree into a file
	 */
	private void saveTree()
	{
		
	}
}