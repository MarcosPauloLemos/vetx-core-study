package com.marcos.vertex.vertex_starter_study.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class VerticleA extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleA.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.debug("Start {}" + getClass().getName());
    vertx.deployVerticle(new VerticleAA(), whenDeployed -> {
      LOG.debug("Deployed {}" + VerticleAA.class.getName());
      vertx.undeploy(whenDeployed.result());
    });
    vertx.deployVerticle(new VerticleAB(), whenDeployed -> {
      LOG.debug("Deployed " + VerticleAB.class.getName());
    });
    startPromise.complete();
  }
}
