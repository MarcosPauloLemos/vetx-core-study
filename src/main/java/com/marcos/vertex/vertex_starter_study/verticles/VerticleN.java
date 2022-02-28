package com.marcos.vertex.vertex_starter_study.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class VerticleN extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleN.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.debug("Start " + getClass().getName() + " with config " + config().toString());
    startPromise.complete();
  }
}
