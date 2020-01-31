class Card {
    public int rank; //数值
    public String suit; //花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.rank == 0) {
            return true;
        }
        if (obj == null || !(obj instanceof Card)) {
            return false;
        }

        Card c = (Card)obj;
        return c.rank == c.rank && suit.equals(c.suit);
    }
}

public class Testequals {
    public static void main(String[] args) {
        Card p = new Card(1,"♥");
        Card q = new Card(1,"♥");
        Card o = p;
        System.out.println(p == q); //f
        System.out.println(p == o); //t

        //不覆写equals默认逻辑就是引用比较
        System.out.println(p.equals(q)); //f t
        System.out.println(p.equals(o)); //t t
    }
}
