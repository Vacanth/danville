package com.vendertool.dal.hibernate;


public class ShardSelectionStrategy {/*extends RoundRobinShardSelectionStrategy {

  public ShardSelectionStrategy(RoundRobinShardLoadBalancer loadBalancer) {
    super(loadBalancer);
  }

  @Override
  public ShardId selectShardIdForNewObject(Object obj) {
    if (obj instanceof Listing) {
    	Listing listing = (Listing) obj;
    	int mod = (int)(listing.getListingId() % 10);
      ShardId id = new ShardId(1);
      return id;
    }else if (obj instanceof ProductSpecification) {
    	Listing listing = (Listing) obj;
    	int mod = (int)(listing.getListingId() % 10);
      ShardId id = new ShardId(1);
      return id;
    }
    return super.selectShardIdForNewObject(obj);
  }*/
}
