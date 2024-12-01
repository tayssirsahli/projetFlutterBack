package com.tayssir.cosmetique.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomcosms", types = { Cosmetique.class })
public interface ArticleProjection{

	public String getNomArticle();

}
