package assignment;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class ItemsetData<I> {
	
	private List<Set<I>> ItemsetList;
    private Map<Set<I>, Integer> supportCountMap;
    private double minimumSupport;
    private int numberOfTransactions;

   public ItemsetData(List<Set<I>> ItemsetList, Map<Set<I>, Integer> supportCountMap, double minimumSupport, int transactionNumber) {
        this.ItemsetList = ItemsetList;
        this.supportCountMap = supportCountMap;
        this.minimumSupport = minimumSupport;
        this.numberOfTransactions = transactionNumber;
    }

    public List<Set<I>> getItemsetList() {
        return ItemsetList;
    }

    public Map<Set<I>, Integer> getSupportCountMap() {
        return supportCountMap;
    }

    public double getMinimumSupport() {
        return minimumSupport;
    }

    public int getTransactionNumber() {
        return numberOfTransactions;
    }

    public double getSupport(Set<I> itemset) {
        return supportCountMap.get(itemset);
    }


}
