package com.vendertool.common.user;

import java.util.List;

import com.vendertool.dal.accountmarketplace.AccountMarketplace;
import com.vendertool.dal.accountmarketplace.AccountMarketplaceDao;
import com.vendertool.dal.accountmarketplace.AccountMarketplaceDaoImpl;
import com.vendertool.mladapter.MarketPlaceUserAdapter;
import com.vendertool.mladapter.factory.IBaseMercadolibreOperationAdapter;
import com.vendertool.mladapter.factory.MercadolibreAdapterFactory;
import com.vendertool.sharedtypes.rnr.GetUserTokenRequest;
import com.vendertool.sharedtypes.rnr.GetUserTokenResponse;

/**
 * 
 * This is the user base utility: Using this all the user related credentials can
 * be accessed.
 * 
 * @author Girish
 *
 */
public class UserUtils {

	private static UserUtils s_self = new UserUtils();
	private UserUtils (){
		
	}
	
	public static UserUtils getInstance(){
		if(s_self == null){
			s_self = new UserUtils();
		}
		return s_self;
	}
	
	//1.
	//Public getToken input userEmail & MarketPlace
	//This should check if the token is active otherwise get new active token from
	//Marketplace and return.
	
	public String getUserAccessToken(long userAccountId){
		AccountMarketplaceDao dao = AccountMarketplaceDaoImpl.getInstance();
		AccountMarketplace am  = new AccountMarketplace();
		am.setAccountId(userAccountId);
		List<AccountMarketplace> list = dao.findByAccountId(am);
		if(list != null && list.size() > 0){
			AccountMarketplace account = list.get(0);
			GetUserTokenRequest request = new GetUserTokenRequest();
			request.setClientId(account.getMpClientId());
			request.setClientSecret(account.getMpClientSecretCode());
			IBaseMercadolibreOperationAdapter adapter = MercadolibreAdapterFactory.getInstance().getOperationAdapter(request);
			GetUserTokenResponse response = (GetUserTokenResponse)adapter.execute(request);
			return response.getAccessToken();
		}
		
		return null;
	}
}