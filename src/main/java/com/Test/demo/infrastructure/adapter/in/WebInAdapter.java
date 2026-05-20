package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.application.port.in.CoderInPort;
import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.dto.CoderSharedDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/web/coders")
public class WebInAdapter {

    private final CoderInPort coderInPort;

    public WebInAdapter(CoderInPort coderInPort){

        this.coderInPort = coderInPort;

    }

    @GetMapping
    public String coderList (Model model){

        model.addAttribute("coders", coderInPort.getAll());

        if (!model.containsAttribute("coderForm")){

            model.addAttribute("coderForm", new CoderSharedDto());
            model.addAttribute("forceForm", false);

        }

        return "index";

    }

    @GetMapping("/save")
    public String createCoder (@ModelAttribute("coderForm") CoderSharedDto dto){

        Coder coderDomain;

        if (dto.getId() != null && !dto.getId().toString().trim().isEmpty()){

            coderDomain = new Coder (dto.getId(), dto.getName(), dto.getClan());

        }else {

            coderDomain = new Coder (null, dto.getName(), dto.getClan());

        }

        coderInPort.save(coderDomain);

        return "redirect:/web/coders";

    }

    @GetMapping("/edit/{id}")
    public String editCoder (@PathVariable UUID id, Model model){

        Coder coderDomain = coderInPort.getById(id);

        CoderSharedDto dto = new CoderSharedDto(coderDomain.getId(), coderDomain.getName(), coderDomain.getClan());

        model.addAttribute("coders", coderInPort.getAll());
        model.addAttribute("coderForm", dto);
        model.addAttribute("forceForm", true);

        return "index";

    }

    @GetMapping("/delete/{id}")
    public String deleteCoder (@PathVariable UUID id){

        coderInPort.delete(id);

        return "redirect:/web/coders";

    }

}
