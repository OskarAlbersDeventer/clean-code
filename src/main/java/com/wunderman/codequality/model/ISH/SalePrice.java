
package com.wunderman.codequality.model.ISH;

import javax.annotation.Generated;


@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SalePrice {


    private String mCurrency;

    private String mCurrencyMnemonic;

    private String mType;

    private Double mValue;

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getCurrencyMnemonic() {
        return mCurrencyMnemonic;
    }

    public void setCurrencyMnemonic(String currencyMnemonic) {
        mCurrencyMnemonic = currencyMnemonic;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Double getValue() {
        return mValue;
    }

    public void setValue(Double value) {
        mValue = value;
    }

}
