package com.moier;

import com.moier.dao.ReadingListRepository;
import com.moier.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Name
 * @Description:
 * @Author hunaghuasong_cd@keruyun.com
 * @Date 2017/8/26 16:47
 */
@Controller
@RequestMapping("/")
public class ReadingListController {


    @Autowired
    private ReadingListRepository readingListRepository;


    @RequestMapping(value = "/{reader}" , method =  RequestMethod.GET)
    public String readersBooks(@PathVariable String reader, Model model){
        List<Book> bookList = this.readingListRepository.findByReader(reader);
        if(null != bookList){
            model.addAttribute("books",bookList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}" , method = RequestMethod.POST)
    public String addToReadingList(@PathVariable String reader,Book book){
        book.setReader(reader);
        this.readingListRepository.save(book);
        return "redirect:/{reader}";
    }

}
