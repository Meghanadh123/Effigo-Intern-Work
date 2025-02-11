package com.example.deepseek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {
	
	@Autowired
	private ChatAIService chatAIService;
	
	@GetMapping("/prompt")
	public String askToAi(@RequestParam(value="question") String question)
	{
		return chatAIService.ask(question);
	}
	
	
	@GetMapping("/prompt/stream")
	public Flux<String> askAiWithStream(@RequestParam(value="question") String question)
	{
		return chatAIService.askWithStream(question);
	}
	
	

}
