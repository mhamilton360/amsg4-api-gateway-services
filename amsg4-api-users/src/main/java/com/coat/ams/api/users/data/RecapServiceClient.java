package com.coat.ams.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coat.ams.api.users.ui.model.AllocationRecapResponseModel;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "recap-ws", fallbackFactory = RecapFallbackFactory.class)
public interface RecapServiceClient {

	@GetMapping("/users/{id}/recap")
	public List<AllocationRecapResponseModel> getRecap(@PathVariable String id);
	
}

@Component
class RecapFallbackFactory implements FallbackFactory<RecapServiceClient> {

	@Override
	public RecapServiceClient create(Throwable cause) {
		return new RecapServiceClientFallback(cause);
	}

}

@Slf4j
class RecapServiceClientFallback implements RecapServiceClient {

	private final Throwable cause;

	public RecapServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<AllocationRecapResponseModel> getRecap(String id) {

		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			log.error("404 error took place when getRecaps was called with userId: " + id + ". Error message: "
					+ cause.getLocalizedMessage());
		} else {
			log.error("Other error took place: " + cause.getLocalizedMessage());
		}

		return new ArrayList<>();
	}

}
