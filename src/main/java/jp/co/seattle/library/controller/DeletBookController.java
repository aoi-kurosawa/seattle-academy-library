package jp.co.seattle.library.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.seattle.library.service.BooksService;

@Controller
public class DeletBookController {
	final static Logger logger = LoggerFactory.getLogger(DeletBookController.class);

	@Autowired
	private BooksService booksService;

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(Locale locale, @RequestParam("bookId") int bookId, Model model) {

		// 書籍情報を更新する
		booksService.deleteBook(bookId);

		// 一覧画面に遷移する
		return "redirect:/home";

	}

}
