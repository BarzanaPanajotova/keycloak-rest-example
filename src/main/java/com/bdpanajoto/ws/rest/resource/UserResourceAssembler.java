package com.bdpanajoto.ws.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.bdpanajoto.ws.rest.domain.User;

@Component
public class UserResourceAssembler extends ResourceAssembler<User, UserResource> {

	@Autowired
	protected EntityLinks entityLinks;

	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";

	@Override
	public UserResource toResource(User user) {

		UserResource resource = new UserResource(user);

		final Link selfLink = entityLinks.linkToSingleResource(user);

		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));
		return resource;
	}
}