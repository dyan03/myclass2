/*
 * Name: An DaeYeong
 * Student ID: 2012136009
 */

public class SinglyLinkedList
{
    /*
     * Our instance variables
     * size will hold the number of elements in the linked list
     * head references the head node in the linked list
     */

    private int size;
    private SinglyLinkedListNode head;

    public SinglyLinkedList()
    {
        /*
         * Our constructor
         * Should initalize the instance variables to their default value
         * Since it is empty at the start, head should be null
         */
        size=0;
        head=null;

    }

    public SinglyLinkedListNode add(char data, int index)
    {
        /*
         * Adds and returns a new node with the provided data at the specified index
         * Returns null if the index is not possible
         */
        SinglyLinkedListNode node= new SinglyLinkedListNode(data);

        if(head==null){
            this.head=node;
            this.size++;
        }else if(index==0){
            node.setNext(this.head);
            this.head=node;
            this.size++; 

        }else if (index==this.getSize()){
            this.getNode(index-1).setNext(node);

        }else if(index<this.getSize()){
            node.setNext(this.getNode(index));
            this.getNode(index-1).setNext(node);
            this.size++;

        }else return null;

        return node;
    }

    public SinglyLinkedListNode delete(int index)
    {
        /*
         * Deletes and returns the node at the index specified
         * Returns null if the index does not exist
         */
        SinglyLinkedListNode tmp=new SinglyLinkedListNode('n');

        if((this.head==null)||(index>=this.getSize())) return tmp;

        if(index==0){
            tmp=this.getNode(index);
            this.head=this.getHead().getNext(); 

        }else if(index==this.size-1){
            tmp=this.getNode(index);
            this.getNode(index-1).setNext(null);

        }else{
            tmp=this.getNode(index);
            this.getNode(index-1).setNext(this.getNode(index+1));
        }
        return tmp;


    }

    public SinglyLinkedListNode deleteItem(char data)
    {
        /*
         * Deletes and returns the first node with the specified data in the linked list
         * Returns null if the item doesn't exist
         */
        int index=0;
        SinglyLinkedListNode cur=new SinglyLinkedListNode('n');
        SinglyLinkedListNode tmp=new SinglyLinkedListNode('n');
        cur=head;
        while(cur.getData()!=data){

            cur=cur.getNext();
            index++;
            if (index==size)return null;

        }
        tmp=this.getNode(index);
        this.delete(index);

        return tmp;
    }

    public boolean contains(char data)
    {
        /*
         * Checks if the linked list contains a node with the specified data
         */
        SinglyLinkedListNode cur=new SinglyLinkedListNode('n');
        cur=this.head;
        do{
            if(cur.getData()==data) return true;
            cur=cur.getNext();

        }while(cur!=null);
        return false;

    }

    public int getSize()
    {
        /*
         * Returns the number of elements in the linked list
         */
        SinglyLinkedListNode cur=new SinglyLinkedListNode('n');
        int count=0;
        if(head==null) return 0;

        cur=this.head;
        do{
            cur=cur.getNext();
            count++;
        }while(cur!=null);
        return count;

    }

    public SinglyLinkedListNode getHead()
    {
        /*
         * Returns the head of the linked list
         */
        return this.head;
    }

    public int getIndex(char data)
    {
        /*
         * Returns the index of the first node with the specified data
         * Returns -1 if the index does not exist
         */ 
        int index=0;
        SinglyLinkedListNode cur=new SinglyLinkedListNode('n');
        SinglyLinkedListNode tmp=new SinglyLinkedListNode('n');
        cur=head;
        while(cur.getData()!=data){
            cur=cur.getNext();
            index++;
            if (index>size)return -1;
        }

        return index;       
    }

    public SinglyLinkedListNode getNode(int index)
    {
        /*
         * Returns the node at the specified index
         * Returns null if the index does not exist
         */
        SinglyLinkedListNode cur=new SinglyLinkedListNode('n');
        SinglyLinkedListNode tmp=new SinglyLinkedListNode('n');
        int c=0;
        cur=this.head;
        if((this.head==null)||(index>=this.getSize())) return null;
        
        while(c<index){
            cur=cur.getNext();
            c++;
        }
        return cur;

    }

    public boolean isEmpty()
    {
        /*
         * Returns whether or not the linked list is empty
         */

        if(this.getHead()==null) return true;
        return false;

    }

    public void clear()
    {
        /*
         * Clears the linked list
         */
        this.head=null;

    }

     public String toString()
    {
        /*
         * Returns the linked list in string form
         * The format is just the data from each node concatenated together
         * See the tests for an example
         * There should be no trailing whitespace
         */
        if(this.getHead()==null) return "no node";
        SinglyLinkedListNode cur=new SinglyLinkedListNode('n');
        cur=this.getHead();
        String s=this.getHead().toString(); 
        while(cur.getNext()!=null){
            s=s+cur.getNext().toString();
            cur=cur.getNext();
        }
        return s;

    }

   
}

class SinglyLinkedListNode
{
    /*
     * Our instance variables
     * data will hold a char
     * next is the reference to the next element after this node (null if there is none)
     */

    private char data;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(char data)
    {
        /*
         * The constructor
         * Should initalize the instance variables to their default value
         */

        this.data=data;
        this.next=null;

    }

    public char getData()
    {
        /*
         * Returns our data
         */

        return this.data;
    }

    public SinglyLinkedListNode getNext()
    {
        /*
         * Returns the SinglyLinkedListNode referenced by next
         */

        return this.next;
    }

    public void setData(char data)
    {
        /*
         * Allows us to change the data stored in our SinglyLinkedListNode
         */
        this.data=data;
    }

    public void setNext(SinglyLinkedListNode node)
    {
        /*
         * Allows us to change the next SinglyLinkedListNode
         */
        this.next=node;
    }

    public void clearNext()
    {
        /*
         * Removes the reference to the next SinglyLinkedListNode, replacing it with null
         */
        this.next=null;
    }

    public String toString()
    {
        /*
         * Returns our data in string form
         */
        String s=this.data+"";
        return s;


    }
}
