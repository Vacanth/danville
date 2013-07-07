package com.vendertool.inventory;

import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.core.MarketEnum;
import com.vendertool.sharedtypes.exception.VTRuntimeException;

public class MarketCountryKey {
	private CountryEnum countryId;
	private MarketEnum marketId;
	
	public MarketCountryKey(CountryEnum countryId, MarketEnum marketId) {
		if((countryId == null) || (marketId == null)) {
			throw new VTRuntimeException("MarketCountryKey: countryId or " +
					"marketId cannot be null");
		}
		this.countryId = countryId;
		this.marketId = marketId;
	}

	public MarketEnum getMarketId() {
		return marketId;
	}
	
	public CountryEnum getCountryId() {
		return countryId;
	}

	@Override
	public boolean equals(Object key1) {
		MarketCountryKey key = (MarketCountryKey)key1;
		if(key == null) {
			return false;
		}
		
		return ((getCountryId() == key.getCountryId()) && 
				(getMarketId() == key.getMarketId()));
	}
	
	public int hashCode() {
        return getCountryId().hashCode() ^ getMarketId().hashCode();
    }
}
