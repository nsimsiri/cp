class Checker implements Comparator<Player>{
    public int compare(Player a, Player b){
        return (a.score==b.score) ? a.name.compareTo(b.name) : new Integer(b.score).compareTo(a.score);
    }
}
