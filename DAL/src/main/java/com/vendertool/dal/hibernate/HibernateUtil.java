package com.vendertool.dal.hibernate;


public class HibernateUtil {/*
  private static final SessionFactory sessionFactory;

  static {
    try {
      AnnotationConfiguration config = (AnnotationConfiguration) new AnnotationConfiguration()
          .configure("product\\hibernate0.cfg.xml");

      config.addAnnotatedClass(Listing.class);
      
      List<ShardConfiguration> shardConfigs = new ArrayList<ShardConfiguration>();
      
      shardConfigs.add(buildShardConfig("product\\hibernate0.cfg.xml"));
      shardConfigs.add(buildShardConfig("product\\hibernate1.cfg.xml"));
      shardConfigs.add(buildShardConfig("product\\hibernate2.cfg.xml"));
     
      ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
      ShardedConfiguration shardedConfig = new ShardedConfiguration(config, shardConfigs,
          shardStrategyFactory);
      
      sessionFactory = shardedConfig.buildShardedSessionFactory();

    }
    catch (Throwable ex) {
      // Make sure you log the exception, as it might be swallowed
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  private static ShardStrategyFactory buildShardStrategyFactory() {
    ShardStrategyFactory shardStrategyFactory = new ShardStrategyFactory() {
      public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
        RoundRobinShardLoadBalancer loadBalancer = new RoundRobinShardLoadBalancer(shardIds);
        ShardSelectionStrategy pss = new com.vendertool.dal.hibernate.ShardSelectionStrategy(loadBalancer);
        ShardResolutionStrategy prs = new AllShardsShardResolutionStrategy(shardIds);
        ShardAccessStrategy pas = new SequentialShardAccessStrategy();

        return new ShardStrategyImpl(pss, prs, pas);
      }
    };
    return shardStrategyFactory;
  }

  private static ShardConfiguration buildShardConfig(String configFile) {
    Configuration config = new Configuration().configure(configFile);
    return new ConfigurationToShardConfigurationAdapter(config);
  }

  public static Session getSession() {
    return sessionFactory.openSession();
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
  
  private static Map<Integer, SessionFactory> shardDbFactoryMap = new HashMap<Integer, SessionFactory>();

  static {
    for (int i = 0; i < 3; i++) {
      
      AnnotationConfiguration config = (AnnotationConfiguration) new AnnotationConfiguration().configure("product\\hibernate" + i + ".cfg.xml");
      config.addAnnotatedClass(Listing.class);
      
      shardDbFactoryMap.put(i, config.buildSessionFactory());      
    }
  }
  
  *//**
   * Gets the Session of the particular database in the shard.
   * 
   * @param shardId Shard Id
   * @return        Sharded Database session.
   *//*
  public static Session getShardDbSession(Integer shardId) {
    return shardDbFactoryMap.get(shardId).openSession();
  }
*/}
