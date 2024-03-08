package org.bhcc;

import java.io.Serializable;

public class Stock  implements Serializable {
    public String tickerSymbol;
    public double currentValue;
    public double valueChange ;
    public String valuePercentChange;

    public Stock(String tickerSymbol, double currentValue, double valueChange, String valuePercentChange) {
        this.tickerSymbol = tickerSymbol;
        this.currentValue = currentValue;
        this.valueChange = valueChange;
        this.valuePercentChange = valuePercentChange;
    }


}
