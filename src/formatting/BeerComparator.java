package formatting;

import generated.BeerType;

import java.util.Comparator;

/**
 * Comparator for comparing our elements from class Beer
 * by value of each Kcalories
 */
public class BeerComparator implements Comparator<BeerType> {
    @Override
    public int compare(BeerType a, BeerType b) {

        return Double.compare(getKcalories(a.getChars().getNutritional()),
                getKcalories(b.getChars().getNutritional()));
    }

    private double getPercents(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 1));
    }
    private double getKcalories(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 5));
    }
}
