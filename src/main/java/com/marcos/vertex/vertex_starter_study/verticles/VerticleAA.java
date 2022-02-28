package com.marcos.vertex.vertex_starter_study.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class VerticleAA extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleAA.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.debug("Start " + getClass().getName() + "on thread " + Thread.currentThread().getName());
    startPromise.complete();
  }

  @Override
  public void stop(Promise<Void> stopPromise) throws Exception {
    LOG.debug("Stop " + getClass().getName());
  }
}
