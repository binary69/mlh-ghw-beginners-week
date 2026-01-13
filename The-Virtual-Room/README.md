Interactive 3D Virtual Room
==========================

Overview
--------
This small demo creates an interactive 3D room using Three.js (r128) embedded in a single HTML file (`index.html`). It provides a 30x30 floor, three walls, ambient/directional/point lighting with shadows, one movable cube and two spheres, basic camera controls, and object drag-and-drop using raycasting.

Location
--------
The demo file is located at:

- The-Virtual-Room/index.html

Quick Start — Open the demo
--------------------------
Option A — Open directly in a browser
- Double-click `The-Virtual-Room/index.html` or open it in your browser (Chrome/Edge/Firefox).

Option B — Serve with a lightweight static server (recommended to avoid local file restrictions)

```bash
# from the workspace root
cd The-Virtual-Room
# Python 3
python -m http.server 8000
# then open http://localhost:8000 in your browser
```

Controls & Interaction
----------------------
- Mouse
  - Click on an object to select it. The selected object shows an emissive glow.
  - While holding the mouse button, move the cursor to drag the object along the floor plane.
  - Release the mouse button to drop the object.
  - Objects are constrained to the room floor bounds (walls block movement).

- Keyboard (camera controls)
  - Arrow keys or `W`/`A`/`S`/`D`: rotate camera around the scene and move it up/down.
  - `Up` / `W`: raise camera height.
  - `Down` / `S`: lower camera height.

Notes on visual/UX feedback
- Selected objects receive an emissive tint for visual feedback.
- The demo uses shadow casting and receiving for depth and realism.

What the program does (function summary)
--------------------------------------
- Creates a Three.js scene with a 30x30 floor and three vertical walls (back, left, right).
- Adds ambient, directional (with shadows), and a colored point light.
- Adds one 2x2x2 cube and two radius-1 spheres at different floor positions.
- Uses a `THREE.Raycaster` to detect mouse interactions with objects and the floor.
- Supports dragging objects along the floor plane while constraining them inside room boundaries.
- Adds small rotation to spheres when not being dragged.
- Uses `requestAnimationFrame` for smooth animation.

Developer Notes / Implementation Details
--------------------------------------
- Three.js is imported from CDN: `https://cdnjs.cloudflare.com/ajax/libs/three.js/r128/three.min.js`.
- Shadows: `renderer` uses shadow mapping with `DirectionalLight.castShadow = true` and object `castShadow` / `receiveShadow` properties applied.
- Camera initially positioned at `(0, 5, 15)` and always looks at the scene center `(0,0,0)`.
- The drag logic projects mouse rays to the floor plane and positions the selected object at the intersection point.
- Event listeners added for `mousedown`, `mousemove`, `mouseup`, `keydown`, and `resize`.
- Basic cleanup for resizing is implemented; see code for `window.removeEventListener` considerations if you expand the demo.

Known Limitations
-----------------
- The demo currently does not change the cursor style during dragging.
- Selection glow is implemented by setting the material's emissive color; more advanced highlighting (post-processing outline/glow) is not included.
- Camera rotation is implemented by modifying `camera.rotation.y` directly; this is simple but not as robust as an orbit control with damping.
- There is no persistence for object positions between sessions.

Suggested Future Improvements
-----------------------------
- UX polish
  - Add a proper loading indicator and ensure all assets (if any) are preloaded.
  - Change the mouse cursor to `grabbing` while dragging and `grab` when hovering selectable objects.
  - Show a subtle outline or post-processing glow on selected objects (using `OutlinePass` / post-processing).

- Camera & Controls
  - Replace manual keyboard rotation with a proper `OrbitControls`-style implementation (custom or from Three.js examples) while keeping constraints to always look at the center.
  - Add smooth easing/damping to camera movements.

- Object Interaction
  - Add physics or collision detection so objects can't overlap when moved.
  - Snap-to-grid or axis constraint modes for precision placement.
  - Undo/redo and position reset functionality.

- Performance & polish
  - Move to a module-based build (React + bundler) for larger projects.
  - Add spatial audio for ambience and interaction sounds.
  - Improve shadow performance by dynamically adjusting shadow camera frustum and updating only when needed.

Troubleshooting
---------------
- If objects do not respond to clicks, ensure the browser allows JavaScript from local files or use a local static server (`python -m http.server`).
- If shadows are missing, confirm the `DirectionalLight` and `Mesh` objects have `castShadow`/`receiveShadow` enabled and the renderer has shadowMap enabled.

Credits
-------
- Built with Three.js (r128) and vanilla JavaScript in a single HTML file.
- Made using copilot as a part of ghw beginners week challenge

