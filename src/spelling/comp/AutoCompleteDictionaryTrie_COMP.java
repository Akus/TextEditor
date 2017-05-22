package spelling.comp;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie_COMP implements  Dictionary, AutoComplete {
private TrieNode root;
private int size;


public AutoCompleteDictionaryTrie_COMP()
{
    root = new TrieNode();
    size=0;
}


/** Insert a word into the trie.
 * For the basic part of the assignment (part 2), you should ignore the word's case.
 * That is, you should convert the string to all lower case as you insert it. */
public boolean addWord(String word)
{
    //TODO: Implement this method.
    String Word=word.toLowerCase();
    if(isWord(Word))
        return false;
    HashMap<Character, TrieNode> children=root.children;
    for(int i=0; i<Word.length(); i++){
        char c = Word.charAt(i);
        TrieNode t;
        if(children.containsKey(c)){
                t = children.get(c);
        }else{
            t = new TrieNode(""+(c));
            children.put(c, t);
        }

        children = t.children;
        if(i==Word.length()-1)
        {
            t.isWord = true; 
            size++;
        }
    }
    return true;
}

/** 
 * Return the number of words in the dictionary.  This is NOT necessarily the same
 * as the number of TrieNodes in the trie.
 */
public int size()
{
    //TODO: Implement this method
    return size;
}


/** Returns whether the string is a word in the trie */
@Override
public boolean isWord(String s) 
{
    // TODO: Implement this method
    TrieNode t = searchNode(s.toLowerCase());

    if(t != null && t.isWord) 
        return true;
    else
        return false;
}
public TrieNode searchNode(String str){
    HashMap<Character, TrieNode> children = root.children; 
    TrieNode t = null;
    for(int i=0; i<str.length(); i++){
        char c = str.charAt(i);
        if(children.containsKey(c)){
            t = children.get(c);
            children = t.children;
        }else{
            return null;
        }
    }

    return t;
}

/** 
 *  * Returns up to the n "best" predictions, including the word itself,
 * in terms of length
 * If this string is not in the trie, it returns null.
 * @param text The text to use at the word stem
 * @param n The maximum number of predictions desired.
 * @return A list containing the up to n best predictions
 */@Override
 public List<String> predictCompletions(String prefix, int numCompletions) 
 {
     // TODO: Implement this method
     // This method should implement the following algorithm:
     // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
     //    empty list
     // 2. Once the stem is found, perform a breadth first search to generate completions
     //    using the following algorithm:
     //    Create a queue (LinkedList) and add the node that completes the stem to the back
     //       of the list.
     //    Create a list of completions to return (initially empty)
     //    While the queue is not empty and you don't have enough completions:
     //       remove the first Node from the queue
     //       If it is a word, add it to the completions list
     //       Add all of its child nodes to the back of the queue
     // Return the list of completions
     List<String> completions=null;
     int counter=0;
     if (prefix==null){
         return Collections.emptyList();
     }

     prefix=prefix.toLowerCase();
     if(isWord(prefix))
         completions.add(prefix);
     LinkedList nodes = new LinkedList();

     TrieNode curr=searchNode(prefix);
     nodes.addLast(curr);
     while(!nodes.isEmpty() && counter!=numCompletions)
     {
         if((nodes.removeFirst()).isWord)
         completions.add(curr.getText());
         TrieNode next = null;
         for (Character c : curr.getValidNextCharacters()) {
                next = curr.getChild(c);
         }
     }


     return Collections.emptyList();

 }
 public void checkNull(String word){
    if (word==null)
        throw new NullPointerException("Null word passed");
 }
// For debugging
public void printTree()
{
    printNode(root);
}

/** Do a pre-order traversal from this node down */
public void printNode(TrieNode curr)
{
    if (curr == null) 
        return;

    System.out.println(curr.getText());

    TrieNode next = null;
    for (Character c : curr.getValidNextCharacters()) {
        next = curr.getChild(c);
        printNode(next);
    }
}



}