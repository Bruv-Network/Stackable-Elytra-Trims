# Stackable Elytra Trims

An addon mod that bridges [Stackable Trims](https://github.com/Bruv-Network/Stackable-Trims) and [Elytra Trims](https://codeberg.org/KikuGie/elytra-trims) to render all stacked trims on elytras.

## The Problem

When both Stackable Trims and Elytra Trims are installed, applying multiple trims to an elytra only renders the last one. This is because Elytra Trims reads the vanilla single-trim component, while Stackable Trims stores trims in a separate stacked list.

## The Fix

This addon uses Elytra Trims rendering API to intercept the trim renderer. When an elytra has multiple stacked trims, it iterates through them and renders each one so all your trims show up.

## Requirements

- **Minecraft** 26.1+
- [Stackable Trims](https://modrinth.com/mod/stackable-trims)
- [Elytra Trims](https://modrinth.com/mod/elytra-trims)

## Supported Platforms

- Fabric
- NeoForge

## Building

```sh
./gradlew build
```

Output JARs will be in `fabric/build/libs/` and `neoforge/build/libs/`.