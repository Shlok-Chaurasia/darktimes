package ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shlok.chaurasia on 18/02/16.
 */
public class TrieNode<T> {
    private Map<T, TrieNode> children = new HashMap<T, TrieNode>();
    private T character;

    public T getCharacter() {
        return character;
    }

    public void setCharacter(T character) {
        this.character = character;
    }

    public Map<T, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<T, TrieNode> children) {
        this.children = children;
    }
}
