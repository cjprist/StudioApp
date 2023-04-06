package com.uncr.studioapp.controller.wallet;

import com.uncr.studioapp.domain.wallet.WalletVO;
import com.uncr.studioapp.service.wallet.WalletService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class WalletController {
    final
    WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
    @RequestMapping(method = RequestMethod.POST, path = "/wallet/pair", produces = "application/json")
    public ResponseEntity<Void> pariWallet(
            @RequestBody WalletVO walletVO){
        walletService.pariWallet(walletVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/wallet/get", produces = "application/json")
    public ResponseEntity<WalletVO> getWallet(
            @RequestParam String walletAddress
    ){
        return new ResponseEntity<>(walletService.getWallet(walletAddress), HttpStatus.OK);
    }
}
