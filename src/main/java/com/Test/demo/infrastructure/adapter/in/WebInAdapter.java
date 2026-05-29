package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.application.port.in.ClanInPort;
import com.Test.demo.application.port.in.CoderInPort;
import com.Test.demo.domain.Clan;
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
    private final ClanInPort clanInPort;

    public WebInAdapter(CoderInPort coderInPort, ClanInPort clanInPort){

        this.coderInPort = coderInPort;
        this.clanInPort = clanInPort;

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
        Clan clan = clanInPort.getById(dto.clan());

        if (dto.id() != null && !dto.id().toString().trim().isEmpty()){

            coderDomain = new Coder (dto.id(), dto.name(), clan);

        }else {

            coderDomain = new Coder (null, dto.name(), clan);

        }

        coderInPort.save(coderDomain);

        return "redirect:/web/coders";

    }

    @GetMapping("/edit/{id}")
    public String editCoder (@PathVariable UUID id, Model model){

        Coder coderDomain = coderInPort.getById(id);

        CoderSharedDto dto = new CoderSharedDto(coderDomain.getId(), coderDomain.getName(), coderDomain.getActive() ,coderDomain.getClan().getId());

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
