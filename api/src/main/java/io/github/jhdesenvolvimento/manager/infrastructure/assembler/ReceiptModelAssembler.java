/*
 * Copyright (c) 2026. Heber Ferreira Barra, João Gabriel de Cristo
 * Licensed under the Massachusetts Institute of Technology (MIT) License.
 * You may obtain a copy of the license at:
 *
 *    https://choosealicense.com/licenses/mit/
 *
 * A short and simple permissive license with conditions only requiring preservation of copyright and license notices.
 * Licensed works, modifications, and larger works may be distributed under different terms and without source code.
 *
 */

package io.github.jhdesenvolvimento.manager.infrastructure.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import io.github.jhdesenvolvimento.manager.infrastructure.controller.ReceiptController;
import io.github.jhdesenvolvimento.manager.infrastructure.entity.Receipt;
import org.jspecify.annotations.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ReceiptModelAssembler
        implements RepresentationModelAssembler<@NonNull Receipt, @NonNull EntityModel<@NonNull Receipt>> {

    @Override
    public @NonNull EntityModel<@NonNull Receipt> toModel(@NonNull Receipt receipt) {
        return EntityModel.of(
                receipt,
                linkTo(methodOn(ReceiptController.class).getOne(receipt.getId()))
                        .withSelfRel(),
                linkTo(methodOn(ReceiptController.class).all()).withRel("receipts"),
                linkTo(methodOn(ReceiptController.class).update(receipt, receipt.getId()))
                        .withRel("update"));
    }
}
