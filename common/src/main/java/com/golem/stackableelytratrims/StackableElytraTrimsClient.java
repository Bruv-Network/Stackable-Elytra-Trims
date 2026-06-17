package com.golem.stackableelytratrims;

import com.golem.stackabletrims.component.StackableTrimsComponents;
import dev.kikugie.elytratrims.api.render.ETRenderParameters;
import dev.kikugie.elytratrims.api.render.ETRendererID;
import dev.kikugie.elytratrims.api.render.ETRenderingAPI;
import dev.kikugie.elytratrims.render.impl.ETTrimsRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.trim.ArmorTrim;

import java.util.List;

public final class StackableElytraTrimsClient {

    public static void initClient() {
        ETRendererID trimRendererType = ETTrimsRenderer.type;

        ETRenderingAPI.wrapRenderCall(trimRendererType, (parameters, collector, original) -> {
            ItemStack stack = parameters.stack();

            // Guard against the component type not being registered yet
            if (StackableTrimsComponents.STACKABLETRIMS == null) {
                return original.apply(parameters, collector);
            }

            List<ArmorTrim> stackedTrims = stack.get(StackableTrimsComponents.STACKABLETRIMS);

            if (stackedTrims == null || stackedTrims.size() <= 1) {
                // Single trim or no stacked trims — let ETTrimsRenderer handle it normally
                return original.apply(parameters, collector);
            }

            // Multiple stacked trims — render each one
            boolean rendered = false;
            ArmorTrim originalTrim = stack.get(DataComponents.TRIM);

            for (ArmorTrim trim : stackedTrims) {
                // Temporarily set the vanilla TRIM component to this trim
                // so ETTrimsRenderer.prepare() picks it up
                stack.set(DataComponents.TRIM, trim);

                ETRenderParameters newParams = ETTrimsRenderer.INSTANCE.prepare(parameters);
                rendered = original.apply(newParams, collector) || rendered;
            }

            // Restore original trim
            if (originalTrim != null) {
                stack.set(DataComponents.TRIM, originalTrim);
            } else {
                stack.remove(DataComponents.TRIM);
            }

            return rendered;
        });
    }
}
