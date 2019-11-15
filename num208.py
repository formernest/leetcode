class TrieNode():
   
    def __init__(self):
        self.R = 26
        self.isEnd = False
        self.links = [TrieNode() for _ in range(self.R)]
    
    def containKey(self, ch):
        return self.links[ch - 'a'] != None

    def get(self, ch):
        return self.links[ch - 'a']

    def put(self, ch, node):
        self.links[ch - 'a'] = node

    def setEnd(self):
        self.isEnd = True


class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node = self.root
        for item in word:
            if node.containKey(item) is False:
                node.put(item, TrieNode())
                node = node.get(item)
        node.setEnd()

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.searchPrefix(word)
        return node != None and node.isEnd
        
    def searchPrefix(self, word):
        node = self.root
        for item in word:
            if node.containKey(item):
                node = node.get(item)
            else:
                return None
        return node

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.searchPrefix(prefix)
        return node != None
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)