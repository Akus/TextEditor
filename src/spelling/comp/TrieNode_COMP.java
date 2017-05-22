package spelling.comp;

import java.util.HashMap;
import java.util.Set;

/** 
* Represents a node in a Trie
* @author UC San Diego Intermediate Programming MOOC Team
*
 */
class TrieNode {
HashMap<Character, TrieNode> children; 
private String text;  // Maybe omit for space
boolean isWord;

/** Create a new TrieNode */
public TrieNode()
{
    children = new HashMap<Character, TrieNode>();
    text = "";
    isWord = false;
}

/** Create a new TrieNode given a text String to store in it */
public TrieNode(String text)
{
    this();
    this.text = text;
}

/** Return the TrieNode that is the child when you follow the 
 * link from the given Character 
 * @param c The next character in the key
 * @return The TrieNode that character links to, or null if that link
 *   is not in the trie.
 */
public TrieNode getChild(Character c)
{
    return children.get(c);
}

/** Inserts this character at this node.
 * Returns the newly created node, if c wasn't already
 * in the trie.  If it was, it does not modify the trie
 * and returns null.
 * @param c The character that will link to the new node
 * @return The newly created TrieNode, or null if the node is already 
 *     in the trie.
 */
public TrieNode insert(Character c)
{
    if (children.containsKey(c)) {
        return null;
    }

    TrieNode next = new TrieNode(text + c.toString());
    children.put(c, next);
    return next;
}

/** Return the text string at this node */
public String getText()
{
    return text;
}

/** Set whether or not this node ends a word in the trie. */
public void setEndsWord(boolean b)
{
    isWord = b;
}

/** Return whether or not this node ends a word in the trie. */
public boolean endsWord()
{
    return isWord;
}

/** Return the set of characters that have links from this node */
public Set<Character> getValidNextCharacters()
{
    return children.keySet();
}

}

/*
//Trying to find the stem in Trie
     String prefixToCheckLowerCase = prefix.toLowerCase();
     int completionsCount = 0;
     List<String> completions = new LinkedList<String>();
     TrieNode traversal = root;
     for (int i = 0; i < prefixToCheckLowerCase.length(); i++)
     {
         if (traversal.getValidNextCharacters().contains(prefixToCheckLowerCase.charAt(i)))
        {
            traversal = traversal.getChild(prefixToCheckLowerCase.charAt(i));
        } 
         //Means  stem not found, returns an empty list
         else
            return completions;
     }
     //If current word is an end word, increment the counter and add it to compeltions list
     if (traversal.endsWord()) 
     {
         completionsCount=1;
         completions.add(traversal.getText());
     }

     List<TrieNode> nodesToBeSearched = new LinkedList<TrieNode>();
     List<Character> ChildCharaterList = new LinkedList<Character>(traversal.getValidNextCharacters());
     //Filling the list with children of the current node, first level of of the breadth first search 
     for (int i=0; i<ChildCharaterList.size(); i++) 
     {
         nodesToBeSearched.add(traversal.getChild(ChildCharaterList.get(i)));
     }
     //while loop for the linked list elements and see if any compeltions exists , inside it we will also check each node children and add them to the list!!!
     while (nodesToBeSearched!=null  && nodesToBeSearched.size()>0 && completionsCount < numCompletions)
     {
         TrieNode trieNode = nodesToBeSearched.remove(0);
         if (trieNode.endsWord()) 
         {
             completionsCount++;
             completions.add(trieNode.getText());
         }

         List<Character> subTrieNodeCholdren = new LinkedList<Character>(trieNode.getValidNextCharacters());
         //Adding all next level tries to the linked list , kinda recursive!!!
         for (int i=0; i<subTrieNodeCholdren.size();i++) 
         {
             nodesToBeSearched.add(trieNode.getChild(subTrieNodeCholdren.get(i)));
         }
     }
     return completions;
*/
